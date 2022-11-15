@pedido_faturado
Feature:Sample criar pedido faturado

  Background:
    * url 'https://api-rtf-dh.mdb.com.br/mdb-rf-dev-b2b-eapi/BOOrderIntegration/BOOrderIntegration'

  Scenario: Pedido Faturado
 * def random =
"""
function(s) {
  var randomInt2 = Math.random().toFixed(s).split('.')[1];
  var randomNum = randomInt2;
  return randomNum;
}
"""
  * def pedido = random(9)
   * print '####################################'
  * print pedido
  * def req = read('pedido_faturado.xml')
  
    Given request read('pedido_faturado.xml')
    * header Authorization = 'Basic MDcyMDY4MTYwMDc2MzI6dGVzdGUxMjM='
    When soap action ''
    Then status 200
    
